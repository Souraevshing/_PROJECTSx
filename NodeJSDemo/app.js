// const names = require('./4-names')
// const utils = require('./3-utils')
// const alternative = require('./6-alternative')

// utils()
// require('./5-modules')

const { readFile } = require('fs')

console.log('1st task')

readFile('../Built-in-Modules/testFSModule.txt', 'utf8', (err, result) => {
  if (err) {
    console.log(err)
    return
  }
  console.log(result)
  console.log('completed 1st task')
})

console.log('next task')
