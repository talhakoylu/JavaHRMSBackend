package net.ahmettalha.javahrmsbackend.business.constants;

public class Messages {
    public static class CandidateUser{
        public static String getAllSuccess = "All candidates are listed.";
        public static String candidateAddSuccess = "Candidate has successfully registered.";
        public static String emailAlreadyExistsError = "This email is already exists.";
        public static String identityNumberExistsError = "This identity number is already exists.";
        public static String mernisVerificationError = "Your personal information is incorrect, verification failed.";
        public static String blankFieldError = "All fields are required. You cannot leave any blank space.";
    }

    public static class EmployerUser{
        public static String blankFieldError = "All fields are required. You cannot leave any blank space.";
        public static String emailAlreadyExistsError = "This email is already exists.";
        public static String emailAndWebsiteUrlMatchError = "Your email extension must be same as your website url.";
        public static String addSuccess = "Employer added successfully.";
    }

    public static class JobPosting{
        public static String blankFieldError = "You cannot leave any blank field except min & max salary fields.";
        public static String jobPostDoesNotExists = "There is no job posting for this ID value.";
        public static String postChangedToActive = "Post status changed to active";
        public static String postChangedToPassive= "Post status changed to passive";
    }

    public static class Education{
        public static String addSuccess = "Education details were added successfully.";
        public static String dateListingSuccess = "Results are listed by date.";
    }

    public static class School{
        public static String addSuccess = "School was added.";
        public static String getAllSuccess = "Schools were listed.";
    }

    public static class SchoolDepartment{
        public static String addSuccess = "Department was added.";
        public static String getAllSuccess = "Departments were listed.";
    }

    public static class JobExperience{
        public static String dateListingSuccess = "Results are listed by date.";
        public static String addSuccess = "Job experience was added.";
    }

    public static class ForeignLanguage{
        public static String addSuccess = "Foreign language was added.";
    }

    public static class CandidateForeignLanguage{
        public static String addSuccess = "Candidate foreign language was added.";
        public static String languageLevelError = "Language level error.";
    }

    public static class CandidateLink{
        public static String addSuccess = "Links were added.";
    }

    public static class Resume{
        public static String addSuccess = "Resume was added.";
    }
}
