import { User } from "../models/user";
import { Observable } from "rxjs";

export interface IUserService {
    testConnection(): any; 
    authentication(user: User): Observable<User>;
    getAllUsers(): Observable<User[]>;
    currentAccount(user:User): Observable<User>;
    currentDeposit(user:User): Observable<User>;
    updateDeposit(user:User): Observable<User>;
    currentWithdraw(user:User): Observable<User>;
    updateWithdraw(user:User): Observable<User>;
    currentTransfer(user:User): Observable<User>;
    updateTransfer(user:User): Observable<User>;
    getWidthdrawAmounts(): void;
}
