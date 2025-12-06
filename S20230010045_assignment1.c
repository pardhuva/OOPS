#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct emp {
    char name[10];
    char id[10];
    float salary;            
    int allowance_per;       
};

void swap(struct emp *a, struct emp *b) {
    struct emp temp = *a;
    *a = *b;
    *b = temp;
}
void heapify(struct emp *employee, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    
    if (left < n && employee[left].allowance_per > employee[largest].allowance_per) {
        largest = left;
    }

    
    if (right < n && employee[right].allowance_per > employee[largest].allowance_per) {
        largest = right;
    }

    
    if (largest != i) {
        swap(&employee[i], &employee[largest]);
        heapify(employee, n, largest);
    }
}


void buildheap(struct emp *employee, int n) {
    int startIndex = n / 2 - 1; 
    for (int i = startIndex; i >= 0; i--) {
        heapify(employee, n, i);
    }
}


float calculateTotalSalary(float basicSalary, int allowancePercentage) {
    return basicSalary + (basicSalary * allowancePercentage / 100.0);
}


void searchById(struct emp *employee, int n, const char *id) {
    for (int i = 0; i < n; i++) {
        if (strcmp(employee[i].id, id) == 0) {
            printf("Employee found:\n");
            printf("Name: %s\n", employee[i].name);
            printf("ID: %s\n", employee[i].id);
            printf("Basic Salary: %.2f\n", employee[i].salary);
            printf("Allowance Percentage: %d\n", employee[i].allowance_per);
            printf("Total Salary: %.2f\n", calculateTotalSalary(employee[i].salary, employee[i].allowance_per));
            return;
        }
    }
    printf("Employee with ID %s not found.\n", id);
}


void listEmployees(struct emp *employee, int n) {
    printf("\nEmployee details:\n");
    for (int i = 0; i < n; i++) {
        printf("%s %s %.2f %d %.2f\n", employee[i].name, employee[i].id, employee[i].salary, employee[i].allowance_per, calculateTotalSalary(employee[i].salary, employee[i].allowance_per));
    }
}

int main() {
    int n;
    printf("Enter the number of employees: ");
    scanf("%d", &n);

    struct emp *employee = malloc(n * sizeof(struct emp));
    if (employee == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        printf("Enter details for employee %d (name id salary allowance_per): ", i + 1);
        scanf("%s %s %f %d", employee[i].name, employee[i].id, &employee[i].salary, &employee[i].allowance_per);
    }

    buildheap(employee, n);

    listEmployees(employee, n);

    char searchId[10];
    printf("\nEnter ID of the employee to search: ");
    scanf("%s", searchId);

    searchById(employee, n, searchId);

    free(employee);
    return 0;
}
