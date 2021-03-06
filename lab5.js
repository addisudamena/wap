function sum(array){
    return array.reduce((a,b)=>a+b,0);
}

function a_starters_with_five(array){
    return array.filter(a=>a.length>=5).filter(a=>a.indexOf('s')>-1);
}

function dynamicFilter(array,n,m){
    return array.filter(a=>a.length>=n).filter(a=>a.indexOf(m)>-1);
}

function Employee(firstName, lastName,birthDate){
    this.firstName=firstName;
    this.lastName=lastName;
    this.birthDate= birthDate;
    this.getFullName=function(){
        return this.firstName+" "+this.lastName;
    }
    this.getAge=function(){
        return new Date(Date.now()-this.birthDate.getTime()).getUTCFullYear() - 1970;
    }
}

function emp_above_20(emps){
    //I had to map it so that the out put is visible
    return emps.filter(e=>e.getAge()>20).map(e=>e.getFullName());
}

function emps_after_2000(emps){
    return emps.filter(e=>e.birthDate.getFullYear()>2000).map(e=>e.getFullName())
}


//Demonstration
document.write("<br> Sum of arrays : "+sum([1,50,40,3,10]));
document.write("<br> Words of length >=5 and contains letter a : "+a_starters_with_five(["new","one","echo","Addisu","fiver","Alemu"]));
document.write("<br> dynamic filter : "+dynamicFilter(["new","one","echo","Addisu","fiver","Alemu"],3,'n'));

document.write("<br> ");

let employees=[]

employees.push(new Employee("Hilu","Teshome",new Date(1984,11,13)));
employees.push(new Employee("Misgana","Teka",new Date(2010,12,25)));
employees.push(new Employee("Melkamu","Tsadik",new Date(1991,11,15)));
employees.push(new Employee("Tesema","Damte",new Date(2003,10,10)));

//display employees
for(let i in employees)
    document.write("<br> "+employees[i].getFullName()+" "+employees[i].getAge());

document.write("<br> ");

document.write("<br> Employee age> 20 "+emp_above_20(employees));
document.write("<br> Employee born after 2000 "+emps_after_2000(employees));

