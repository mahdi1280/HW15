package ir.maktab;

import ir.maktab.service.BorrowService;
import ir.maktab.service.PersonService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

    private static final PersonService personService;
    private static final BorrowService borrowService;

    static {
        personService = new PersonService();
        borrowService = new BorrowService();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        String[] split = count.split(" +");
        Map<String, Long> stringLongMap = new HashMap<>();
        long priceLate = Long.parseLong(split[1]);
        for (int i = 0; i < Integer.parseInt(split[0]); i++) {
            String input = scanner.nextLine();
            String[] split1 = input.split(" +");
            LocalDateTime of = LocalDateTime.of(Integer.parseInt(split1[2]), Integer.parseInt(split1[1]), Integer.parseInt(split1[0]), 0, 0);
            if (!stringLongMap.containsKey(split1[3])) {
                stringLongMap.put(split1[3], (LocalDateTime.now().getDayOfYear() -of.getDayOfYear()- 7) * priceLate);
            } else {
                Long aLong = stringLongMap.get(split1[3]);
                stringLongMap.put(split1[3], aLong + (LocalDateTime.now().getDayOfYear() -of.getDayOfYear()- 7) * priceLate);
            }
        }

        System.out.println("Fines:");
        for (Map.Entry<String, Long> stringLongEntry : stringLongMap.entrySet()) {
            System.out.println(stringLongEntry.getKey() + ": " + stringLongEntry.getValue());
        }

    }
}
