from dataclasses import dataclass


@dataclass
class StationsQuery:
    query: str
    maxResults: int = 5
    isSimple: bool = True


@dataclass
class RoutesQuery:
    startingStation: str
    arrivingStation: str
    date: str
    hour: int
    min: int
    maxChanges: int
    maxWalk: int
