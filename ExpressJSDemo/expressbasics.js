const express = require('express')
const app = express()

app.get('/', (req, res) => {
  res.status(200).send('<h2>Welcome</h2>')
})

app.get('/about', (req, res) => {
  res.status(200).send('<h2>About</h2>')
})

app.all('*', (req, res) => {
  res.status(404).send('<h2>Resource not found</h2>')
})

app.listen(9800, () => {
  console.log('Server running')
})
