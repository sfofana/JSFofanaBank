const express = require('express');
let router = express.Router();
let service = require('../services/userService.js');
let objectId = require('mongoose').Types.ObjectId;

router.post('/api/v1/user', (request, response) =>{
    service.User.findOne({id: request.body.id}, (error, data) => {
            if(!error){
                response.send(data);
            } else{
                console.log('empty');
            }
        });
});

router.put('/api/v1/user', (request, response) =>{
    if (!objectId.isValid(request.body._id)){
        return response.status(400).send('User not found');
    }

    let user = {
        email: request.body.email,
        password: request.body.password,
        accounts: request.body.accounts
    };

    service.User.findByIdAndUpdate(request.body._id, { $set: user }, { new: true }, (error, data) => {
        if(!error) {
            response.send(data);
        } 
        else {
            console.log('Internal Error with Transaction: ' + JSON.stringify(error, undefined, 2));
        }
    });
});

//Howdy world
router.get('/api/v1/user/:query', (request, response) =>{
    let user = service.hello(request.params.query);
    response.send(user);
});

//Add users to database
router.post('/api/v1/users', (request, response) =>{
    let user = service.addUser(request.body);
    response.send(user);
});

module.exports = router;