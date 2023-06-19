"use client";
import {useState} from "react";
import {Button, ChakraProvider, FormControl, Input, InputGroup, InputLeftElement} from "@chakra-ui/react";
import axios from "axios";

export default function Home() {
    const [honnan, setHonnan] = useState("");
    const [hova, setHova] = useState("");

    return (
        <ChakraProvider>
            <h1>Hello</h1>
            <form>
                <FormControl>
                    <InputGroup>
                        <InputLeftElement
                            pointerEvents="none"
                        />
                        <Input
                            borderRadius='xl'
                            placeholder="Honnan"
                            onChange={(e) =>  {
                                setHonnan(e.target.value);
                                axios.post('http://localhost:8080/api/queryStations', {
                                    query: honnan,
                                    maxResults: 5
                                })
                                    .then(function (response) {
                                        console.log(response);
                                    });
                            }} />
                    </InputGroup>
                </FormControl>
                <FormControl>
                    <InputGroup>
                        <InputLeftElement
                            pointerEvents="none"
                        />
                        <Input
                            borderRadius='xl'
                            placeholder="Hova"
                            onChange={(e) =>  {
                                setHova(e.target.value);
                                axios.post('http://localhost:8080/api/queryStations', {
                                    query: hova,
                                    maxResults: 5
                                })
                                    .then(function (response) {
                                        console.log(response);
                                    });
                            }} />
                    </InputGroup>
                </FormControl>
                <Button
                    borderRadius='xl'
                    type="submit"
                    variant="solid"
                    colorScheme="teal"
                    width="full"
                    onClick={(e) => {

                    }}
                >
                    Keresés
                </Button>
            </form>
        </ChakraProvider>
  )
}
