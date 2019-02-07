--������� ���� ��� ���������� ������� ������ �������� � ������ � � ��������
select * 
from customers c 
inner join orders o on c.cust_num = o.cust
inner join products p on p.product_id = o.product 
where p.description like '%�%';

--STEP 26

-- ������� ������ ���� �������, ������� ����� � ��������� ������, � ��� �� ��� ������� � ����� �������.
select order_num, (qty * amount) as total, company, credit_limit 
from orders o 
inner join customers c on o.cust = c.cust_num 
order by order_num;

--������� ������ ���� ��������, ������� ������ � �������, � ������� ��� ��������.
select empl_num, name, city, region 
from salesreps s 
inner join offices o on s.rep_office = o.office 
order by s.name;

--������� ������ ������, ������� �� ����� � �������
select city, name, title 
from offices o 
inner join salesreps s on o.mgr = s.empl_num;

--B������ ������ ������, ������� �� ����� � �������, � ��� �� ���� ������, ������� ��������� $600.00
select city, name, title, target 
from offices o 
inner join salesreps s on o.mgr = s.empl_num and target > 600;

--B������ ������ ���� �������, � ��� ����� � �� ��������� � �������� �������
select order_num, (qty * amount) as total, description 
from orders o 
inner join products p on o.mfr = p.mfr_id and o.product = p.product_id 
order by order_num;

--STEP 27

--B������ ������ ������� ���������� ���� $700, ������� ��� ���������, ���������� ����� � ��� ������� ���������� ���.
select order_num, amount, name, company 
from orders o 
inner join customers c on o.cust = c.cust_num
inner join salesreps s on o.rep = s.empl_num and amount > 700 
order by amount;

-- B������ ������ ������� ���������� ���� $700, ������� ��� ������� ������������� ����� � ��� ��������� ������������� �� ���� ��������
select order_num, amount, company, name 
from orders o 
inner join customers c on o.cust = c.cust_num
inner join salesreps s on c.cust_rep = s.empl_num and amount > 700 
order by amount;

--������� ������ ������� ���������� ���� $700, ������� ��� �������, ������������� ����� � ��� ���������, ������������� �� ���� ��������,
--� ��� �� ����, � ������� �������� ���� ��������.
select order_num, amount, company, name, city 
from orders o 
inner join customers c on o.cust = c.cust_num
inner join salesreps s on c.cust_rep = s.empl_num
inner join offices off on s.rep_office = off.office and amount > 700 
order by amount;

--STEP 28

--����� ��� ������, ���������� � ��� ����, ����� �� ������ ��� ������ ����� ��������
select Order_Num, Amount, Order_Date, name 
from Orders o 
inner join salesreps s on o.order_date = s.hire_date;

-- �������� ��� ���������� �������� ������, ��� �������� ����� ������ ��������� ������, ��� ���� ������ ���� �����.
select name, quota, city, target
from salesreps s 
inner join offices o on s.quota > o.target;

--STEP 29

--�������� ���, ����, � ����� ������ ������� ���������.
select name, s.sales, city 
from salesreps s 
inner join offices o on s.rep_office = o.office;

-- �������� ��� ����������, � �������� � ������ ��� ��� ��������.
select * 
from salesreps s 
inner join offices o on s.rep_office = o.office;

select s.*, city, region 
from salesreps s 
inner join offices o on s.rep_office = o.office;

--STEP 30

--������� ������ ���� ���� �������� � �� �������������
select e.name, m.name 
from salesreps e 
inner join salesreps m on e.manager = m.empl_num;

-- ������� ������ ��������, ����� ������� ��������� ����� �� �������������
select s.name, s.quota, m.quota 
from salesreps s 
inner join salesreps m on s.manager = m.empl_num and s.quota > m.quota;

--������� ������ ��������, ������� �������� �� ������ �������������� � ��������� ������, ������� ����� � ����� ��� ��������, ��� � �������������.
select emps.name, emp_office.city, mgrs.name, mgr_office.city 
from salesreps emps 
inner join offices emp_office on emps.rep_office = emp_office.office
inner join salesreps mgrs on emps.manager = mgrs.empl_num
inner join offices mgr_office on mgrs.rep_office = mgr_office.office and emps.rep_office <> mgrs.rep_office;

--�������� ��� ��������� ���������� �������� � �������
select name, city 
from salesreps, offices;

--STEP 31

--�������� ������� �������� � ������� ����������� ����� ������ � ��������
select avg(quota), avg(sales) 
from salesreps;

--�������� ������� ������� ���������� ����� � ��������
select avg(100 * (sales/quota))	
from salesreps;

select avg(100 * (sales/quota)) as percent
from salesreps;

--�������� ������� �������� � ������� ����������� ������ ������, �������� ��������
select sum(quota), sum(sales)
from salesreps;

--�������� ����� ���� ������� �������� ����� ���������
select sum(amount) 
from orders, salesreps 
where name = '���� �������' and rep = empl_num;

select sum(amount) 
from orders o 
inner join salesreps s on o.rep = s.empl_num and name = '���� �������';

--��������� ������� ���� ������� �� ������������� "ACI".
select avg(price)
from products
where mfr_id = 'ACI';

--��������� ������� ��������� ������, ������������ ��������� "Acme Mfg". (������������� ������� 2103)
select avg(amount)
from orders
where cust = 2103;

--STEP 32

--�������� ���������� � ���������� �������� ������ ������?
select min(quota), max(quota)
from salesreps;

--�������� ����� ��� ������ ����� ������ �� ���� ������������ � ���� ������ �������?
select min(order_date)
from orders;

--�������� ���������� ������� ���������� ����� ����� ���� ��������?
select max(100 * (sales/quota))
from salesreps;

--������� �������� � ����� ��������?
select count(cust_num)
from customers;

--������� �������� ������������� ����?
select count(name)
from salesreps
where sales > quota;

--������� ������� ������� ���������� ����� $250 ?
select count(amount)
from orders
where amount > 250;

select count(*)
from orders
where amount > 250;

-- ����� ������� ��������� �������, ����� ��������� �������, ������� ���������
--������� � ��������� �� ������� ������� ��������, � ����� ������� ��������� ������� � ��������� �� �������� ������� ������ ��������.
select avg(amount), sum(amount), (100 * avg(amount/credit_limit)), (100 * avg(amount/quota)) 
from orders o 
inner join customers c on o.cust = c.cust_num
inner join salesreps s on o.rep = s.empl_num; 