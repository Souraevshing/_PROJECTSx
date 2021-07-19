const http = require('http')

const server = http.createServer((req, res) => {
  if (req.url === '/') {
    res.end('Hello, Welcome!')
  } else if (req.url === '/home') {
    res.end('Welcome to homepage')
  } else {
    res.end('Sorry! Error!!!')
  }
})

server.listen(9800)
