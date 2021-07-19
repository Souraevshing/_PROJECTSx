const http = require('http')
const fs = require('fs')

http
  .createServer(function (res, req) {
    const fileStream = fs.createReadStream(
      '../Built-in-Modules/testFSModule.txt',
      'utf8'
    )
    fileStream.on('open', () => {
      fileStream.pipe(res)
    })
    fileStream.on('error', (err) => {
      res.end(err)
    })
  })
  .listen(9800)
