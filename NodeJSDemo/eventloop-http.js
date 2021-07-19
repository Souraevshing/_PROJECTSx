const http = require('http')

const server = http.createServer((_req, res) => {
  console.log('req event')
  res.end('<h1>HY</h1>')
})

server.listen(9800, () => {
  console.log('listening on 9800')
})
