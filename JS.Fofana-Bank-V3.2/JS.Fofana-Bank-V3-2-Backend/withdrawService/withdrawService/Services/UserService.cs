using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using withdrawService.Contexts;
using withdrawService.Models;

namespace withdrawService.Services
{
    public class UserService : IUserService
    {
        private readonly UserContext context;
        public UserService(UserContext contextDpnd)
        {
            context = contextDpnd;
        }

        public User currentWithdraw(User user)
        {
            List<Account> accounts = context.Account.ToList()
               .FindAll(data => data.user == user.id);
            user.accounts = accounts;
            return user;
        }

        public List<User> GetUsers()
        {
            List<User> users = context.User.ToList();
            List<Account> accounts = context.Account.ToList();
            foreach (User user in users)
            {
                user.accounts = accounts
                    .FindAll(data => data.user == user.id);
            }
            return users;
        }

        public User updateWithdraw(User user)
        {
            context.Entry(user).State = EntityState.Modified;
            foreach (Account account in user.accounts)
            {
                context.Entry(account).State = EntityState.Modified;
            }
            context.SaveChanges();
            return user;
        }
    }
}
