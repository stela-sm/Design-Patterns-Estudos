class Singleton:
    def __init__(self):
        if(Singleton.instance == None):
            Singleton.instance = self
            self.value = 0
            print("Instância nova.")
        
        return Singleton.instance
    

   def increment(self):
        self.value += 1
        print(f"Value: {self.value}")
    



//CLIENT

const s1 = Singleton()
const s2 = new Singleton();
s1.increment()

console.log(s2.value)
console.log(s1 == s2);