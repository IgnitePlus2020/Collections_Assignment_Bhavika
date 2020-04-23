package com.tgt.igniteplus;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class Main {
    static List<IgniteMember> member = new CopyOnWriteArrayList<>();
    static List<String> Department = new ArrayList<>();
    static Set<String> SkillSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opt;

        Set<String> gauthamSkillSet = new HashSet<>();
        gauthamSkillSet.add("Java");
        gauthamSkillSet.add("SQL");
        gauthamSkillSet.add("DS");

        Set<String> divyaSkillSet = new HashSet<>();
        divyaSkillSet.add("Java");
        divyaSkillSet.add("NOSQL");
        divyaSkillSet.add("ML");

        Set<String> amitSkillSet = new HashSet<>();
        amitSkillSet.add("Linux");
        amitSkillSet.add("PSQL");
        amitSkillSet.add("Scripting");

        Set<String> naveenSkillSet = new HashSet<>();
        naveenSkillSet.add("Chef");
        naveenSkillSet.add("React");
        naveenSkillSet.add("AI");

        Department.add("Data Science");
        Department.add("Infrastructure");

        member.add(new IgniteMember("Gautham", "VTU", Department.get(0), gauthamSkillSet, 28));
        member.add(new IgniteMember("Divya", "TGT", Department.get(0), divyaSkillSet, 26));
        member.add(new IgniteMember("Amit", "TMT", Department.get(1), amitSkillSet, 25));
        member.add(new IgniteMember("Naveen", "DOJO", Department.get(1), naveenSkillSet, 22));

        do {
            System.out.println(
                    "Press the option from the menu:\n" +
                    "1. Display list of Departments\n" +
                    "2. Create a new Department\n" +
                    "3. Delete a Department\n" +
                    "4. Display all Members based on departments\n" +
                    "5. Create a Member and add to a department\n" +
                    "6. Display members based on given skill\n" +
                    "7. Swap department of a member\n" +
                    "8. Add new skill set to all members of a department\n"
                   );

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    displayDepartment();
                    break;
                case 2:
                    String department = createDepartment();
                    System.out.println("Enter a member to this department:");
                    createMember(department);
                    break;
                case 3:
                    removeDepartment();
                    break;
                case 4:
                    displayMemberDeptWise();
                    break;
                case 5:
                    createMember(null);
                    break;
                case 6:
                    displayMemberSkillWise();
                    break;
                case 7:
                    swapDeparment();
                    break;
                case 8:
                    addNewSkill();
                    break;
                default:
                    System.out.print("Invalid option!\n");
            }
            System.out.print( "Do you want to continue? (1/0):\t");
            opt = in.nextInt();
        } while (opt == 1);
        System.exit(0);
    }


    private static void createMember(String deptParam) {
        Scanner in = new Scanner(System.in);
        Set<String> SkillSet = new HashSet<>();
        String newName, newCollege;
        String dept = deptParam;
        int newAge, count, deptChoice;
        System.out.print("\nEnter the Name of the member:\t");
        newName = in.next();
        do {
            for (IgniteMember im : member) {
                if (im.getName().contains(newName)) {
                    System.out.print("\nName already exists!\n" + "Enter a UNIQUE name:\t");
                    newName = in.next();
                }
            }
        } while (member.contains(newName));
        System.out.print("Enter the Age of the member:\t");
        newAge = in.nextInt();
        System.out.print("Enter the College of the member:\t");
        newCollege = in.next();
        System.out.print("Enter the number of skills:\t");
        count = in.nextInt();
        System.out.print("Enter the Skill Set:\t");
        for (int j = 0; j < count; j++) {
            String newSkill = in.next();
            SkillSet.add(newSkill);
        }
        if (dept == null) {
            System.out.println("\nAdd the member to one of the departments:");
            int j = 1;
            for (String deptObj : Department) {
                System.out.println(j + ". " + deptObj);
                j++;
            }
            System.out.print("Enter your option:\t");
            deptChoice = in.nextInt();
            int k = 1;
            for (String deptObj : Department) {
                if (k == deptChoice) {
                    dept = deptObj;
                    break;
                }
                k++;
            }
        }
        member.add(new IgniteMember(newName, newCollege, dept, SkillSet, newAge));
        System.out.println("Created!");
    }
    private static String createDepartment() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the name of the department to be added:\t");
        String newDept = in.next();
        Department.add(newDept);
        return newDept;
    }
    private static void removeDepartment() {
        Scanner in = new Scanner(System.in);
        int deptChoice;
        String deleteDept = null;
        System.out.println("\nEnter the department to be deleted:\t");
        int j = 1;
        for (String deptObj : Department) {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department) {
            if (k == deptChoice) {
                deleteDept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMember mem : member) {
            if (mem.getDepartment().contains(deleteDept)) {
                member.remove(mem);
            }
        }
        Department.remove(deleteDept);
        System.out.println("Removed!");
    }

    private static void displayDepartment() {
        int i = 1;
        System.out.println("\nDepartments:");
        for (String deptObj : Department) {
            System.out.println(i + ". " + deptObj);
            i++;
        }
    }

    private static void addNewSkill() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the new skill:\t");
        String newSkill = in.next();
        System.out.print("Enter the department choice:\n");
        int j = 1;
        for (String deptObj : Department) {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        String dept = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department) {
            if (k == deptChoice) {
                dept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMember im : member) {
            if (im.getDepartment().contains(dept)) {
                Set<String> skill = im.getSkillSet();
                skill.add(newSkill);
                im.setSkillSet(skill);
            }
        }
        System.out.println("Added!");
        for (IgniteMember im : member)
            if (im.getDepartment().contains(dept))
                System.out.println("Name:\t" + im.getName() + "\t\t\tSkills:\t" + im.getSkillSet());
    }


    private static void displayMemberDeptWise() {
        System.out.println("\nDEPARTMENT\t\t\t|\t\tMEMBER NAME\n" + "-------------------------------------------------");
        for (IgniteMember mem : member) {
            System.out.println(mem.getDepartment() + "\t\t|\t\t" + mem.getName());
        }
    }


    private static void displayMemberSkillWise() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the skill:\t");
        String skill = in.nextLine();
        System.out.println("\nMembers having " + skill + " skills:");
        for (IgniteMember ig : member) {
            if (ig.getSkillSet().contains(skill))
                System.out.println(ig);
        }
    }
    private static void swapDeparment() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the member who's department you want to change:\t");
        String memName = in.next();
        System.out.println("Enter the choice of department:");
        int j = 1;
        for (String deptObj : Department) {
            System.out.println(j + ". " + deptObj);
            j++;
        }
        String dept = null;
        int deptChoice = in.nextInt();
        int k = 1;
        for (String deptObj : Department) {
            if (k == deptChoice) {
                dept = deptObj;
                break;
            }
            k++;
        }
        for (IgniteMember im : member) {
            if (im.getName().contains(memName))
                im.setDepartment(dept);
        }
    }

}

