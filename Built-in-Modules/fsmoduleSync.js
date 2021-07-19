const { readFileSync, writeFileSync } = require('fs')

const testWrite = writeFileSync(
  'testFSModule.txt',
  'hello nodeJS extra info added',
  { flag: 'w' }
)

const testRead = readFileSync('testFSModule.txt', 'utf-8')

console.log(testRead)
