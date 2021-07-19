const http = require('http')
const { readFileSync } = require('fs')

const doc = readFileSync('./index.html')

const server = http.createServer((req, res) => {
  const url = req.url
  if (url === '/') {
    res.writeHead(200, { 'content-type': 'text/html' })
    res.write('<h1>Hello, User Welcome to our homepage</h1>')
    res.write(doc)
    res.end()
  } else if (url === '/about') {
    res.writeHead(200, { 'content-type': 'text/html' })
    res.write(
      '<h1>Hello, User Welcome to our About Section</h1><br><p>About Us<p>'
    )
    res.end()
  } else if (url === '/help') {
    res.writeHead(200, { 'content-type': 'text/html' })
    res.write(
      '<h1>Hello, User Welcome to our Help Section</h1><br><p>Help Me<p>'
    )
    res.end()
  } else {
    res.writeHead(404, { 'content-type': 'text/html' })
    res.write('<h1>Sorry! Unauthorized access.</h1><br><p>Page not found.</p>')
    res.end()
  }
})

server.listen(9800)
