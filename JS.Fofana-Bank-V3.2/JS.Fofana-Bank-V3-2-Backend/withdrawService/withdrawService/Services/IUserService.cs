using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using withdrawService.Models;

namespace withdrawService.Services
{
    public interface IUserService
    {
        List<User> GetUsers();
        User currentWithdraw(User user);
        User updateWithdraw(User user);
    }
}
