set -e

projects=(itau-core) 

for i in "${projects[@]}"
    do
        PGPASSWORD="postgres" createdb --host 'localhost' --port '5432' --username 'postgres' $i  ;
        PGPASSWORD="postgres" psql -d $i --host 'localhost' --port '5432' --username 'postgres' -c " CREATE SCHEMA IF NOT EXISTS itau-core;  CREATE SCHEMA IF NOT EXISTS public;";
    done

