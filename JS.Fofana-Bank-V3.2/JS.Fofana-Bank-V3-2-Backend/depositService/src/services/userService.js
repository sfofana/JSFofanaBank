const {User} = require('../models/user.js');

function hello(word) {
    return 'howdy world ' + word;
}

function getUser(body){
    let user = User.find({id: body.id});
    // User.find({id: body.id}, (error, data) => {
    //     if(!error){
    //         console.log(data);
    //         this.user = JSON.stringify(data);
    //         console.log(user);
    //         //this.user = data;
    //     } else{
    //         console.log('empty');
    //         user = null;
    //     }
    // });

    console.log(user);
    return user;
}

function addUser(body){
    let user = new User({
        id: body.id,
        firstname: body.firstname,
        lastname: body.lastname,
        email: body.email,
        password: body.password,
        accounts: body.accounts
    });

    user.save((error, data) => {
        if(!error){
            return data;
        }else{
            console.log('Internal Error');
        }
    });
}

function updateUser(){

}

module.exports = {hello, getUser, addUser, updateUser, User};