const { MongoClient } = require('mongodb')

async function main() {
  //const uri =
  //  'mongodb+srv://mongodemo:Sk@100600@cluster0.7pvlw.mongodb.net/test?retryWrites=true&w=majority'

  const uri = 'mongodb://localhost:27017/test'
  const client = new MongoClient(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })

  //Connecting to mongodb
  try {
    await client.connect()
    console.log('\n<---Connected--->\n')
    await findSingleList(client, 'saurav')
    await findMultipleList(client, {
      name: 'saurav',
      age: 22,
      city: 'Bhagalpur',
    })
  } finally {
    await client.close()
    console.log('\n<---Disconnected--->\n')
  }
}

main().catch(console.error)

async function findSingleList(client, newList) {
  const result = await client
    .db('data')
    .collection('info')
    .findOne({ name: newList })

  if (result) {
    console.log(`Found a listing in the collection with the name '${newList}':`)
    console.log(result)
  } else {
    console.log(`No listings found with the name '${newList}'`)
  }
}

async function findMultipleList(client, newList) {
  const cursor = client.db('data').collection('info').find({}) //here 'find({})' is equivalent to select * from table in mysql
  //projection in second parameter of find(), to filter fields i.e. 0 => no 1 => yes.
  const cursor1 = client
    .db('data')
    .collection('info')
    .find({}, { projection: { _id: 0, name: 1, age: 1 } })
  const results = await cursor.toArray()
  const results1 = await cursor1.toArray()
  console.log('\nFetching multiple list\n')
  if (results1) {
    console.log(results1)
    console.log(results1[2].age) //returns the third index of age in collection.
  }
}
