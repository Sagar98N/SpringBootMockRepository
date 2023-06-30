function manipulateStudentRecord(obj, operation, prop, newValue){
    if(operation=== 'delete'){
        const newObj = {...obj};
        delete newObj[prop];
        return newObj;
    }
    else if (operation === 'edit') {
        return {...obj, [prop]:newValue};
    }
}

const obj = {name:'John', age:20, grade:'A'};
const operation = 'edit';
const prop = 'age';
const newValue = 21;

const result = manipulateStudentRecord(obj, operation, prop, newValue);
console.log(result)