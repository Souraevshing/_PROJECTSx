const express = require('express')
const app = express()
const { products } = require('./data')

app.get('/', (req, res) => {
  res.send('<h1> Home Page</h1><a href="/api/products">products</a>')
})

app.get('/api/products', (req, res) => {
  const newProducts = products.map((product) => {
    const { id, name, image } = product
    return { id, name, image }
  })
  res.json(newProducts)
})

/** route param to fetch one product at a time */

// app.get('/api/products/1', (req, res) => {
//   const single = products.find((product) => product.id == 1)
//   res.json(single)
//   console.log(single)
// })

app.get('/api/products/:id', (req, res) => {
  //console.log(req)
  //console.log(req.params)
  const { id } = req.params
  const single = products.find((product) => product.id === Number(id))
  res.json(single)
  console.log(single)
})

/** query string */
app.get('/api/v2/query', (req, res) => {
  const { search, limit } = req.query
  let querySearch = [...products]

  if (search) {
    querySearch = querySearch.filter((product) => {
      return product.name.startsWith(search)
    })
  }
  if (limit) {
    querySearch = querySearch.slice(0, Number(limit))
  }

  if (querySearch.length < 1) {
    return res.status(200).json({ success: true, data: [] })
  }

  res.status(200).json(querySearch)
})

app.listen(9800, (req, res) => {
  console.log('Server running')
})
