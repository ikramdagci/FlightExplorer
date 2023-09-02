const express = require('express');
const chance = require('chance').Chance();
const app = express();
const port = 3000;

// Sabit bir havaalanı kodları listesi
const airportCodes = ['IST', 'ESB', 'ADB', 'AYT', 'ADA', 'JFK', 'LAX', 'LHR', 'DXB', 'HKG', 'CDG', 'SIN', 'SAW', 'GZP', 'BJV', 'DLM', 'TZX', 'ORD', 'HND', 'PEK', 'PVG', 'FRA', 'AMS', 'YYZ', 'BOM', 'SYD', 'ICN', 'SFO', 'MEX'];

const getRandomAirportCodes = (count) => {
  const uniqueCodes = Array.from(new Set(airportCodes)); // Aynı kodları filtrele
  const randomCodes = chance.pickset(uniqueCodes, count); // Belirli sayıda rastgele kod seç
  return randomCodes;
};

const generateFlightData = () => {
  const [departureAirportCode, arrivalAirportCode] = getRandomAirportCodes(2);

  const departureDateTime = chance.date();
  const maxArrivalDateTime = new Date(departureDateTime);
  maxArrivalDateTime.setHours(departureDateTime.getHours() + 24);

  const arrivalDateTime = chance.date({ min: departureDateTime, max: maxArrivalDateTime });

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

// /flight endpoint'i
app.get('/flight', (req, res) => {
  const flight = generateFlightData();
  res.json(flight);
});

// /flights endpoint'i
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
  console.log(`Uygulama http://localhost:${port} adresinde çalışıyor.`);
});
