package se.andolf.nordic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.andolf.nordic.config.properties.WorkoutConfiguration;
import se.andolf.nordic.models.WorkoutType;
import se.andolf.nordic.resources.SheetResource;
import se.andolf.nordic.resources.workouts.DagensResource;
import se.andolf.nordic.resources.workouts.FitnessResource;
import se.andolf.nordic.resources.workouts.CompetitionResource;

@Configuration
public class WorkoutConfig {

    @Bean
    public DagensResource dagensResource(SheetResource sheetResource) {
        final WorkoutConfiguration workoutConfiguration = WorkoutConfiguration.builder()
                .workoutType(WorkoutType.DAGENS_PASS)
                .tabName("'Trän.plan - Dagens pass'")
                .build();
        return new DagensResource(workoutConfiguration, sheetResource);
    }

    @Bean
    public FitnessResource fitnessResource(SheetResource sheetResource) {
        final WorkoutConfiguration workoutConfiguration = WorkoutConfiguration.builder()
                .workoutType(WorkoutType.FITNESS)
                .yearStartCell(3030)
                .tabName("'Trän.plan - Fitness'")
                .build();
        return new FitnessResource(workoutConfiguration, sheetResource);
    }

    @Bean
    public CompetitionResource competitionResource(SheetResource sheetResource) {
        final WorkoutConfiguration workoutConfiguration = WorkoutConfiguration.builder()
                .workoutType(WorkoutType.COMPETITION)
                .yearStartCell(5742)
                .tabName("'Trän.plan - Perf'")
                .endColumn("L")
                .build();
        return new CompetitionResource(workoutConfiguration, sheetResource);
    }
}
