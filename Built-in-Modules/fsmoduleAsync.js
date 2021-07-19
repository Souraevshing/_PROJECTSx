const { readFile, writeFile } = require('fs')

writeFile(
  'testFSModule.txt',
  'hello nodeJS extra info added testing async fs module',
  (err, result) => {
    if (err) {
      console.log(err)
      return
    }
    console.log(result)
  }
)

readFile('testFSModule.txt', 'utf8', (err, result) => {
  if (err) {
    console.log(err)
    return
  }
  console.log(result)
})
