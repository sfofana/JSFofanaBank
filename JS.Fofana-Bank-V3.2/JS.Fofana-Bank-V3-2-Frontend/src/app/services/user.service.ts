import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { SubjectService } from './subject.service';
import { IUserService } from './iuser-service';

@Injectable({
  providedIn: 'root'
})
export class UserService implements IUserService {

  // private username = "sfofana";
  // private password = "UofH2011";
  private connection = environment.connection;
  private url = environment.url;
  private authUrl = environment.authUrl;
  private accountUrl = environment.accountUrl;
  private depositUrl = environment.depositUrl;
  private withdrawUrl = environment.withdrawUrl;
  private transferUrl = environment.transferUrl;
  private money: Array<number> = [10, 20, 50, 100, 200, 500, 1000, 2000, 5000];

  constructor(private http: HttpClient) { }
  
  public testConnection(): any {
    return this.http.get(this.connection);
  }

  public authentication(user: User): Observable<User>{
    //const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(this.username+":"+this.password)});
    return this.http.post<User>(this.authUrl, user);
  }

  public currentAccount(user:User): Observable<User> {
    return this.http.post<User>(this.accountUrl, user);
  }

  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.authUrl);
  }

  public updateUser(user:User): Observable<User> {
    return this.http.put<User>(this.authUrl, user);
  }

  // Deposit endpoints
  public currentDeposit(user:User): Observable<User> {
    return this.http.post<User>(this.depositUrl, user);
  }

  public updateDeposit(user:User): Observable<User> {
    return this.http.put<User>(this.depositUrl, user);
  }

  // Withdraw endpoints
  public currentWithdraw(user:User): Observable<User> {
    return this.http.post<User>(this.withdrawUrl, user);
  }

  public updateWithdraw(user:User): Observable<User> {
    return this.http.put<User>(this.withdrawUrl, user);
  }

  // Transfer endpoints
  public currentTransfer(user:User): Observable<User> {
    return this.http.post<User>(this.transferUrl, user);
  }

  public updateTransfer(user:User): Observable<User> {
    return this.http.put<User>(this.transferUrl, user);
  }

  public getWidthdrawAmounts(){
    return this.money;
  }
}
