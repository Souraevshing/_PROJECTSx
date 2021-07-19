const { createReadStream } = require('fs')

const stream = createReadStream('../Built-in-Modules/testFSModule.txt', {
  encoding: 'utf8',
})

//Displays the total bytes in the given file.

stream.on('data', (result) => {
  console.log(result)
})
