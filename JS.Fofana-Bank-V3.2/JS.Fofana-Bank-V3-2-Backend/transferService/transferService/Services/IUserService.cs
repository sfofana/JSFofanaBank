using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using transferService.Models;

namespace transferService.Services
{
    public interface IUserService
    {
        List<User> GetUsers();
        User currentTransfer(User user);
        User updateTransfer(User user);
    }
}
