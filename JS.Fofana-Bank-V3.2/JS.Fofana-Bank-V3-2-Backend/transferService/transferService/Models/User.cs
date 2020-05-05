using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace transferService.Models
{
    public class User
    {
        public int id { get; set; }
        public string _id { get; set; }
        public string firstname { get; set; }
        public string lastname { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public List<Account> accounts { get; set; }
    }
}
