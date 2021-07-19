const { readFile, writeFile } = require('fs').promises

const start = async () => {
  try {
    const first = await readFile('../Built-in-Modules/testFSModule.txt', 'utf8')
    const second = await readFile(
      '../Built-in-Modules/testFSModule.txt',
      'utf8'
    )
    await writeFile(
      '../Built-in-Modules/testFSModule.txt',
      `Adding files ${first}${second}`,
      { flag: 'a' }
    )
    console.log(first)
    console.log(second)
  } catch (error) {
    console.log(error)
  } finally {
    console.log('Finally block executes after every execution')
  }
}

start()

// const getText = (path) => {
//   return new Promise((resolve, reject) => {
//     readFile(path, 'utf8', (err, result) => {
//       if (err) {
//         reject(err)
//       } else {
//         resolve(result)
//       }
//     })
//   })
// }

// getText('../Built-in-Modules/testFSModule.txt')
//   .then((data) => console.log(data))
//   .catch((err) => console.log(err))
