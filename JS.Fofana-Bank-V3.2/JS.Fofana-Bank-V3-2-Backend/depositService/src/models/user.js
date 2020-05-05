const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    id: {type: Number},
    firstname: {type: String},
    lastname: {type: String},
    email: {type: String},
    password: {type: String},
    accounts: {type: Array,
        items:{type: Object,
        properties:{
            id:{type:Number},
            name:{type:Number},
            amount:{type:Number},
            user:{type:Number}
        }}}
});

const User = mongoose.model('MicroBank3-2Users', userSchema);

module.exports = {User};