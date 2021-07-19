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
    //var myquery = { name: 'kumar' }
    //var newvalues = { $set: { name: 'Mickey', age: 22 } }
    await deleteOneField(client, { name: 'saurav' })
  } finally {
    await client.close()
    console.log('\n<---Disconnected--->\n')
  }
}

main().catch(console.error)

async function deleteOneField(client, newList) {
  const result = await client.db('data').collection('info').deleteOne(newList)

  console.log(`${result.matchedCount} documents matched`)
  console.log(`${result.modifiedCount} documents were deleted`)
}
