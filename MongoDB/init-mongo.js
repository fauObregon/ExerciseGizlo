db.createUser(
    {
        user : "fobregon",
        pwd : "fobregonpwd",
        roles : [
            {
                role : "readWrite",
                db : "exercise_gizlo"
            }
        ]
    }
);