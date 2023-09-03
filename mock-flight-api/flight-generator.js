const express = require('express');
const chance = require('chance').Chance();
const app = express();
const port = 3000;

const airportCodes = ['SAW', 'ESB', 'AYT', 'JFK', 'LAX', 'LHR', 'DXB', 'HND', 'CDG', 'AMS', 'SYD'];

const getRandomAirportCodes = (count) => {
  const uniqueCodes = Array.from(new Set(airportCodes)); 
  const randomCodes = chance.pickset(uniqueCodes, count); 
  return randomCodes;
};

const generateRandomDateInRange = () => {
  const now = new Date();
  const startDate = new Date(now);
  const endDate = new Date(now);
  endDate.setDate(now.getDate() + (365)); 
  const randomDate = chance.date({ min: startDate, max: endDate });
  return randomDate;
};

const generateFlightData = () => {
  const [departureAirportCode, arrivalAirportCode] = getRandomAirportCodes(2);

  const departureDateTime = generateRandomDateInRange();
  const maxArrivalDateTime = new Date(departureDateTime);
  maxArrivalDateTime.setHours(departureDateTime.getHours() + 24);

  const arrivalDateTime = new Date(departureDateTime);
  arrivalDateTime.setHours(departureDateTime.getHours() + chance.integer({ min: 1, max: 24 })); // 1 ila 24 saat arası bir saat ekleyin
  return {
    departureAirportCode,
    arrivalAirportCode,
    departureDateTime: departureDateTime.toISOString(),
    arrivalDateTime: arrivalDateTime.toISOString(),
    price: {
      amount: chance.floating({ min: 50, max: 500, fixed: 2 }),
      currency: chance.pickone(['USD', 'EUR', 'GBP', 'TRY'])
    }
  };
};

app.get('/flight', (req, res) => {
  const flight = generateFlightData();
  res.json(flight);
});

app.get('/flights/:numberOfFlights', (req, res) => {
  const numberOfFlights = parseInt(req.params.numberOfFlights, 10);
  const flightsData = [];

  for (let i = 0; i < numberOfFlights; i++) {
    const flight = generateFlightData();
    flightsData.push(flight);
  }

  res.json(flightsData);
});

app.listen(port, () => {
  console.log(`Running on http://localhost:${port}`);
});
