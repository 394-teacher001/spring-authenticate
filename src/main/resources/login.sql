select
    users.role as role,
    accounts.name as name, 
    accounts.email as email,
    accounts.password as password
from accounts
join users on users.email = accounts.email;