using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using transferService.Models;
using transferService.Services;

namespace transferService.Controllers
{
    [Route("api/v1")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserService userService;
        public UserController(IUserService userServiceDpnd)
        {
            userService = userServiceDpnd;
        }

        [HttpGet("users")]
        public List<User> getAllUsers()
        {
            return userService.GetUsers();
        }

        [HttpPost("user")]
        public User getCurrentTrasfer([FromBody] User user)
        {
            return userService.currentTransfer(user);
        }

        [HttpPut("user")]
        public User updateTransfer([FromBody] User user)
        {
            return userService.updateTransfer(user);
        }
    }
}

