const { MongoClient } = require('mongodb')

async function main() {
  //const uri =
  //  'mongodb+srv://mongodemo:Sk@100600@cluster0.7pvlw.mongodb.net/test?retryWrites=true&w=majority'

  const uri = 'mongodb://localhost:27017/test'
  const client = new MongoClient(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })

  //Connecting to mongo and creating collection

  try {
    await client.connect()
    console.log('\n<---Connected--->\n')
    await createListing(client, {
      name: 'saurav',
      age: 22,
      city: 'Bhagalpur',
    })
    await createMultipleListing(client, [
      {
        name: 'kumar',
        age: 23,
        roll: 5933217,
      },
      {
        name: 'shing',
        age: 22,
        roll: '0126ec181020',
      },
    ])
  } finally {
    await client.close()
    console.log('\n<---Dis-connected--->\n')
  }
}

main().catch(console.error())

async function createListing(client, newList) {
  const result = await client.db('data').collection('info').insertOne(newList)
  console.log(`List created ${result.insertedId}`)
}

async function createMultipleListing(client, newList) {
  const result = await client.db('data').collection('info').insertMany(newList)
  console.log(`${result.insertedCount} created`)
  console.log(`List created ${result.insertedIds}`)
}
