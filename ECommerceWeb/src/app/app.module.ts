import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { DemoAngularMaterailModule } from './DemoAngularMaterialModule';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { DemofdeleteComponent } from './demofdelete/demofdelete.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    DemofdeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DemoAngularMaterailModule,
    
],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
//sample comment
