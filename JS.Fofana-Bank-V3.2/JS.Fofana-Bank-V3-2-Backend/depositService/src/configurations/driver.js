const mongoose = require('mongoose');
const uri = "mongodb+srv://sfofana:UofH2011@collection-abpcc.mongodb.net/Data?retryWrites=true&w=majority";

mongoose.connect(uri, { useNewUrlParser: true, useUnifiedTopology: true }, (error)=>{
    if(!error) console.log('Successful Conncetion to Database');
    else console.log('Server Error: ' + JSON.stringify(error, undefined, 2));
});

module.exports = mongoose;