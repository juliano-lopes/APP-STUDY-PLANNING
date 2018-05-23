package br.com.julopes.tadsprointer;
public class User {
private String name;
private String email;
private String senha;
public User(){
this.name="";
this.email="";
this.senha="";
}
public User(String email, String senha){
this.name = "Usuario";
this.email=email;
this.senha=senha;
}

public User(String name, String email, String senha){
this.name = name;
this.email=email;
this.senha=senha;
}
public String getName(){
return name;
}
public String getEmail(){
return email;
}
public String getSenha(){
return senha;
}
public void setName(String name){
this.name = name;
}
public void setEmail(String email){
this.email = email;
}
public void setSenha(String senha){
this.senha = senha;
}
}