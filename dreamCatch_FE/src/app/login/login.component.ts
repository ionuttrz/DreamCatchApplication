import { Component } from '@angular/core';
import { User } from '../user-model/user';
import { Router } from '@angular/router';
import { LoginUserService } from '../login-service/login-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: User = new User();

  constructor(private loginuserservice: LoginUserService, private router:Router){

  }

  ngOnInit(): void{
    
  }

  onSubmit(): void {
    this.router.navigate(['/metrics']);
  }

  userLogin(){
    console.log(this.user);
    this.loginuserservice.loginUser(this.user).subscribe(data=>{
      this.router.navigate(['/metrics']);
      alert("Login Successfully");
    },error=>{
      alert("Sorry, please enter correct Id and password");
      this.router.navigate(['/login']);
    });
    
  }

}
