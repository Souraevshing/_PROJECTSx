const { createReadStream } = require('fs')

const stream = createReadStream('../Built-in-Modules/testFSModule.txt')

stream.on('data', (result) => {
  console.log(result)
})

stream.on('error', (err) => console.log(err))
