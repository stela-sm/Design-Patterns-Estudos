class Singleton{
    constructor(){
        if(Singleton.instance == null){
            Singleton.instance = this;
            this.value = 0;
            console.log("Instância nova.")
        }
        return Singleton.instance;
    }

    increment(){
        this.value += 1;
        console.log(`Value: ${this.value}`);
    }
}


//CLIENT

const s1 = new Singleton();
const s2 = new Singleton();
s1.increment()

console.log(s2.value)
console.log(s1 == s2);