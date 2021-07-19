const http = require('http')

const server = http.createServer()

server.on('request', (req, res) => {
  res.end('Hello User!')
})

server.listen(9800)
