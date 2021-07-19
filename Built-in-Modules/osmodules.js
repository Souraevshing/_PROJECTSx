const OS = require('os')
const host = OS.hostname()
const user = OS.userInfo()
console.log(host)
console.log(user)
console.log(`Uptime is ${OS.uptime() / 100000} sec`)
const OsInfo = {
  name: OS.type(),
  release: OS.release(),
  Memory: OS.totalmem(),
  FreeMemory: OS.freemem(),
  architecture: OS.arch(),
}
console.log(OsInfo)
