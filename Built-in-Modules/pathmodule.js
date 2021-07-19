const PATH = require('path')

const joinPATH = PATH.join('/Built-in-Modules', 'pathmodules', 'text.txt')

const basePATH = PATH.basename(joinPATH)

const absolutePATH = PATH.resolve(
  __dirname,
  'Built-in-Modules',
  'pathmodules',
  'text.txt'
)

console.log(joinPATH)
console.log(PATH.sep)
console.log(basePATH)
console.log(absolutePATH)
