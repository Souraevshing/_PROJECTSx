const { MongoClient } = require('mongodb')

async function main() {
  // const uri =
  //   'mongodb+srv://mongodemo:Sk@100600@cluster0.7pvlw.mongodb.net/test?retryWrites=true&w=majority'

  const uri = 'mongodb://localhost:27017/test'
  const client = new MongoClient(uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })

  try {
    await client.connect()
    console.log('connected')
  } catch (err) {
    console.error(err)
  } finally {
    await client.close()
    console.log('dis-connected')
  }
}

main()
