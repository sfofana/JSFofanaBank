using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using withdrawService.Models;
using withdrawService.Services;

namespace withdrawService.Controllers
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
        public User getCurrentWithdraws([FromBody] User user)
        {
            return userService.currentWithdraw(user);
        }

        [HttpPut("user")]
        public User updateWithdraw([FromBody] User user)
        {
            return userService.updateWithdraw(user);
        }
    }
}
