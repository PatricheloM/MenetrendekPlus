import asyncio
from datetime import datetime, date
from typing import Optional

import httpx

from nicegui import events, ui
from nicegui.elements.input import Input

from model import constants, requests

from dataclasses import asdict

api = httpx.AsyncClient()
running_query: Optional[asyncio.Task] = None


async def query_routes() -> None:
    global running_query
    if running_query:
        running_query.cancel()
    running_query = asyncio.create_task(api.post(
        url='http://localhost:8079/api/queryRoutes',
        headers=constants.CONTENT_TYPE_JSON,
        json=asdict(query.convert_query_to_model())
    ))
    response = await running_query
    print(response.json())
    table.options['rowData'] = response.json()
    table.update()
    running_query = None


async def search_starting(e: events.ValueChangeEventArguments) -> None:
    global running_query
    if running_query:
        running_query.cancel()
    results1.clear()
    running_query = asyncio.create_task(api.post(
        url='http://localhost:8079/api/queryStations',
        headers=constants.CONTENT_TYPE_JSON,
        json=asdict(requests.StationsQuery(query=e.value)))
    )
    response = await running_query
    if response.text == '':
        return
    with results1:
        for station in response.json() or []:
            x = station
            ui.button(x, on_click=lambda: set_search_field(search_field1, x))
    running_query = None


async def search_destination(e: events.ValueChangeEventArguments) -> None:
    global running_query
    if running_query:
        running_query.cancel()
    results2.clear()
    running_query = asyncio.create_task(api.post(
        url='http://localhost:8079/api/queryStations',
        headers=constants.CONTENT_TYPE_JSON,
        json=asdict(requests.StationsQuery(query=e.value)))
    )
    response = await running_query
    if response.text == '':
        return
    with results2:
        for station in response.json() or []:
            ui.button(station, on_click=lambda: set_search_field(search_field2, station))
    running_query = None


ui.label("Honnan:")
search_field1 = ui.input(on_change=search_starting) \
    .props('outlined rounded item-aligned input-class="ml-3"') \
    .classes('w-96')
results1 = ui.row()

ui.label("Hova:")
search_field2 = ui.input(on_change=search_destination) \
    .props('outlined rounded item-aligned input-class="ml-3"') \
    .classes('w-96')
results2 = ui.row()


def set_search_field(field: Input, text: str) -> None:
    field.value = text


class Query:
    date: str = str(date.today())
    hour: int = int(datetime.now().strftime("%H"))
    min: int = int(datetime.now().strftime("%M"))

    def set_date(self, in_date: str):
        self.date = in_date

    def set_time(self, in_time: str):
        self.hour = int(in_time.split(':')[0])
        self.min = int(in_time.split(':')[1])

    def set_min(self, in_min):
        self.min = in_min

    def __init__(self):
        self.is_change = False
        self.is_walk = False
        self.change = 1
        self.walk = 250

    def convert_query_to_model(self) -> requests.RoutesQuery:
        return requests.RoutesQuery(
            search_field1.value,
            search_field2.value,
            self.date,
            self.hour,
            self.min,
            self.change if self.is_change else 0,
            self.walk if self.is_walk else 0
        )


query = Query()
v1 = ui.checkbox('Átszállás', value=False).bind_value(query, 'is_change')
with ui.column().bind_visibility_from(v1, 'value'):
    ui.toggle({1: '1', 2: '2', 3: '3', 4: '4', 5: '5'}).bind_value(query, 'change')

v2 = ui.checkbox('Séta', value=False).bind_value(query, 'is_walk')
with ui.column().bind_visibility_from(v2, 'value'):
    ui.toggle({250: '250', 500: '500', 1000: '1000', 2000: '2000', 5000: '5000'}).bind_value(query, 'walk')

ui.date(value=str(date.today()), on_change=lambda e: query.set_date(e.value))

ui.time(value=datetime.now().strftime("%H:%M"), on_change=lambda e: query.set_time(e.value))

ui.button('Keresés', on_click=lambda: query_routes())

table = ui.aggrid({'columnDefs': [
    {'headerName': 'Honnan', 'field': 'startingStation'},
    {'headerName': 'Hova', 'field': 'arrivingStation'},
    {'headerName': 'Indulás', 'field': 'startingTime'},
    {'headerName': 'Érkezés', 'field': 'arrivingTime'},
    {'headerName': 'Menetidő', 'field': 'duration'}
], 'rowData': []})


ui.run(title="MenetrendekPlus")
