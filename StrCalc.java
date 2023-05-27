import java.util.Scanner;

class StrCalc{
    public static void main(String[] args) throws ThrowExeption {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = sc.nextLine();
        String answer = Calc.calc(expression);

        if (answer.length()>40){
            answer = "\"" + answer.substring(0, 39) + "..." + "\"";
            System.out.println( answer );
        }else{
            answer = "\"" + answer  + "\"";
            System.out.println(answer);
        }
    }
}
class Calc {
    public static String calc(String input) throws ThrowExeption {
        String[] inputSplit = input.split("\"");
        String result = "";
        int num = 1;
        char operation ;

        if (inputSplit.length==4 | inputSplit.length==3 ){   //Узнаем нужной ли днны выражение

        }else{
            throw new ThrowExeption();
        }





        String firstStr = inputSplit[1];
        String secondStr = inputSplit[inputSplit.length-1];
        char op = Sort.operation(input);                     //С помощью метода вычисляем знак операции

        if (op == 0){                                        //Исключаем отсутвие знака
            throw new ThrowExeption();
        }

        if (firstStr.length() > 10 ){  //Исключаем слишком большие строки
            throw new ThrowExeption();
        }

        if (secondStr.length() > 10 ){  //Исключаем слишком большие строки 2
            throw new ThrowExeption();
        }


        switch (op) {

            case '+':
                result = firstStr + secondStr;
                return result;
            case '-':

                if (firstStr.contains(secondStr)) {

                    return firstStr.replace(secondStr,"");
                }else{
                    result = firstStr;
                    return result;
                }
            case '*':
                secondStr = Sort.strOrNum(secondStr);
                num = Integer.valueOf(secondStr);
                if (num>0&&num<=10) {
                    for (int i = 0; i < num; i++) {
                        result += firstStr;;
                    }
                    return result;
                }else{
                    throw new ThrowExeption();
                }
            case '/':
                secondStr = Sort.strOrNum(secondStr);
                num = Integer.valueOf(secondStr);
                if (num>0&&num<=10){
                    result = firstStr.substring(0, firstStr.length() / num);
                    return result;
                }else{
                    throw new ThrowExeption();
                }
            default:
                throw new ThrowExeption();

        }



    }
}




    class Sort {

        public static String strOrNum(String secondStr) throws ThrowExeption { // переводим строку в число
            secondStr=secondStr.substring(3,secondStr.length()) ;
            return secondStr;


        }

         static char operation(String input) {     //вычисдяем оператор
            char operation = 0;
            char[] op = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                op[i] = input.charAt(i);
                if (op[i] == '+') {
                    operation = '+';

                }
                if (op[i] == '-') {
                    operation = '-';

                }
                if (op[i] == '*') {
                    operation = '*';

                }
                if (op[i] == '/') {
                    operation = '/';

                }
            }
            return operation;
        }
    }
