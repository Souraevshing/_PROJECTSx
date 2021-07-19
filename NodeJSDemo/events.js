const EventEmitter = require('events')

const events1 = new EventEmitter()

events1.on('response', () => {
  console.log(`event called!`)
})

events1.on('response', (age, roll) => {
  console.log(`event called! Age is ${age} and roll is ${roll}`)
})

events1.emit('response', 22, 5933217)
//events1.emit('response')
